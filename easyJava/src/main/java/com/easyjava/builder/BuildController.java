package com.easyjava.builder;

import com.easyjava.bean.Constants;
import com.easyjava.bean.FieldInfo;
import com.easyjava.bean.TableInfo;
import com.easyjava.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;
import java.util.Map;

public class BuildController {
    private static final Logger logger = LoggerFactory.getLogger(BuildController.class);

    public static void execute(TableInfo tableInfo) {
        File folder = new File(Constants.PATH_CONTROLLER);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String serviceName = tableInfo.getBeanName() + "Service";
        String serviceBeanName = StringUtils.lowerCaseFirstLetter(serviceName);
        String className = tableInfo.getBeanName() + "Controller";
        File PoFile = new File(folder, className + ".java");

        OutputStream out = null;
        OutputStreamWriter outw = null;
        BufferedWriter bw = null;
        try {
            out = new FileOutputStream(PoFile);
            outw = new OutputStreamWriter(out, "UTF-8");
            bw = new BufferedWriter(outw);
            bw.write("package " + Constants.PACKAGE_CONTROLLER + ";");
            bw.newLine();
            bw.newLine();


//            if (tableInfo.getHaveDate() || tableInfo.getHaveDateTime()) {
//                bw.write(Constants.BEAN_DATE_SERIALIZE_CLASS);
//                bw.newLine();
//                bw.write(Constants.BEAN_DATE_UNSERIALIZE_CLASS);
//                bw.newLine();
//
//                bw.write("import " + Constants.PACKAGE_ENUMS + ".DateTimePatternEnum;");
//                bw.newLine();
//                bw.write("import " + Constants.PACKAGE_UTILS + ".DateUtils;");
//                bw.newLine();
//            }
            bw.write("import " + Constants.PACKAGE_VO + ".ResponseVO;");
            bw.newLine();
            bw.write("import " + Constants.PACKAGE_PO + "." + tableInfo.getBeanName() + ";");
            bw.newLine();
            bw.write("import " + Constants.PACKAGE_QUERY + "." + tableInfo.getBeanParamName() + ";");
            bw.newLine();
            bw.write("import " + Constants.PACKAGE_SERVICE + "." + serviceName + ";");
            bw.newLine();
            bw.write("import org.springframework.web.bind.annotation.RequestBody;");
            bw.newLine();
            bw.write("import org.springframework.web.bind.annotation.RequestMapping;");
            bw.newLine();
            bw.write("import org.springframework.web.bind.annotation.RestController;");
            bw.newLine();
            bw.newLine();

            bw.write("import javax.annotation.Resource;");
            bw.newLine();


            bw.write("import java.util.List;");
            bw.newLine();


            bw.newLine();
            BuildComment.createClassComment(bw, tableInfo.getComment() + "Controller");
            bw.write("@RestController");
            bw.newLine();
            bw.write("@RequestMapping(\"/" + StringUtils.lowerCaseFirstLetter(tableInfo.getBeanName()) + "\")");
            bw.newLine();

            bw.write("public class " + className + " extends ABaseController {");
            bw.newLine();
            bw.newLine();

            bw.write("\t@Resource");
            bw.newLine();
            bw.write("\t private " + serviceName + " " + serviceBeanName + ";");
            bw.newLine();
            bw.newLine();

            BuildComment.createFieldComment(bw, "根据条件分页查询");
            bw.write("\t@RequestMapping(\"loadDataList\")");
            bw.newLine();
            bw.write("\tpublic ResponseVO loadDataList(" + tableInfo.getBeanParamName() + " query) {");
            bw.newLine();
            bw.write("\t\treturn getSuccessResponseVO(" + serviceBeanName + ".findListByPage(query));");
            bw.newLine();
            bw.write("\t}");

            bw.newLine();
            bw.newLine();
            BuildComment.createFieldComment(bw, "新增");
            bw.write("\t@RequestMapping(\"add\")");
            bw.newLine();
            bw.write("\tpublic ResponseVO add(" + tableInfo.getBeanName() + " bean) {");
            bw.newLine();
            bw.write("\t\tthis." + serviceBeanName + ".add(bean);");
            bw.newLine();
            bw.write("\t\treturn getSuccessResponseVO(null);");
            bw.newLine();
            bw.write("\t}");

            bw.newLine();
            bw.newLine();
            BuildComment.createFieldComment(bw, "批量新增");
            bw.write("\t@RequestMapping(\"addBatch\")");
            bw.newLine();
            bw.write("\tpublic ResponseVO addBatch(@RequestBody List<" + tableInfo.getBeanName() + "> listBean) {");
            bw.newLine();
            bw.write("\t\tthis." + serviceBeanName + ".addBatch(listBean);");
            bw.newLine();
            bw.write("\t\treturn getSuccessResponseVO(null);");
            bw.newLine();
            bw.write("\t}");

            bw.newLine();
            bw.newLine();
            BuildComment.createFieldComment(bw, "批量新增/修改");
            bw.write("\t@RequestMapping(\"addOrUpdateBatch\")");
            bw.newLine();
            bw.write("\tpublic ResponseVO addOrUpdateBatch(@RequestBody List<" + tableInfo.getBeanName() + "> listBean) {");
            bw.newLine();
            bw.write("\t\tthis." + serviceBeanName + ".addOrUpdateBatch(listBean);");
            bw.newLine();
            bw.write("\t\treturn getSuccessResponseVO(null);");
            bw.newLine();
            bw.write("\t}");
            bw.newLine();

            for (Map.Entry<String, List<FieldInfo>> entry : tableInfo.getKeyIndexMap().entrySet()) {
                List<FieldInfo> keyFieldInfoList = entry.getValue();

                Integer index = 0;
                StringBuilder methodNmae = new StringBuilder();

                StringBuilder methodParams = new StringBuilder();

                StringBuilder paramsBuilder = new StringBuilder();
                for (FieldInfo fieldInfo : keyFieldInfoList) {
                    index++;
                    methodNmae.append(StringUtils.uperCaseFirstLetter(fieldInfo.getPropertyName()));
                    if (index < keyFieldInfoList.size()) {
                        methodNmae.append("And");
                    }

                    methodParams.append(fieldInfo.getJavaType() + " " + fieldInfo.getPropertyName());
                    paramsBuilder.append(fieldInfo.getPropertyName());
                    if (index < keyFieldInfoList.size()) {
                        methodParams.append(", ");
                        paramsBuilder.append(", ");
                    }
                }
                bw.newLine();
                bw.newLine();
                BuildComment.createFieldComment(bw, "根据" + methodNmae + "查询");
                String requestMethondName = "get" + tableInfo.getBeanName() + "By" + methodNmae;
                bw.write("\t@RequestMapping(\"" + requestMethondName + "\")");
                bw.newLine();
                bw.write("\tpublic ResponseVO " + requestMethondName + "(" + methodParams + ") {");
                bw.newLine();
                bw.write("\t\treturn getSuccessResponseVO(this." + serviceBeanName + ".get" + tableInfo.getBeanName() + "By" + methodNmae + "(" + paramsBuilder + "));");
                bw.newLine();
                bw.write("\t}");

                bw.newLine();
                bw.newLine();
                BuildComment.createFieldComment(bw, "根据" + methodNmae + "更新");
                requestMethondName = "update" + tableInfo.getBeanName() + "By" + methodNmae;
                bw.write("\t@RequestMapping(\"" + requestMethondName + "\")");
                bw.newLine();
                bw.write("\tpublic ResponseVO " + requestMethondName + "(" + tableInfo.getBeanName() + " bean, " + methodParams + ") {");
                bw.newLine();
                bw.write("\t\tthis." + serviceBeanName + ".update" + tableInfo.getBeanName() + "By" + methodNmae + "(bean, " + paramsBuilder + ");");
                bw.newLine();
                bw.write("\t\treturn getSuccessResponseVO(null);");
                bw.newLine();
                bw.write("\t}");

                bw.newLine();
                bw.newLine();
                BuildComment.createFieldComment(bw, "根据" + methodNmae + "删除");
                requestMethondName = "delete" + tableInfo.getBeanName() + "By" + methodNmae;
                bw.write("\t@RequestMapping(\"" + requestMethondName + "\")");
                bw.newLine();
                bw.write("\tpublic ResponseVO " + requestMethondName + "(" + methodParams + ") {");
                bw.newLine();
                bw.write("\t\tthis." + serviceBeanName + ".delete" + tableInfo.getBeanName() + "By" + methodNmae + "(" + paramsBuilder + ");");
                bw.newLine();
                bw.write("\t\treturn getSuccessResponseVO(null);");
                bw.newLine();
                bw.write("\t}");
            }

            bw.newLine();
            bw.write("}");


            bw.flush();
        } catch (Exception e) {
            logger.error("创建Service impl失败", e);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outw != null) {
                try {
                    outw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
