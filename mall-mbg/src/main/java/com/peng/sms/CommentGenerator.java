package com.peng.sms;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * Custom Comment Generator
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private boolean addRemarkComments = false;
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String MAPPER_SUFFIX = "Mapper";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.v3.oas.annotations.media.Schema";

    /**
     * Set user-defined configuration properties
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * Add comments to a field
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        // Determine whether to add Swagger annotation based on config and remarks
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            // Escape special characters in the database remarks
            if (remarks.contains("\"")) {
                remarks = remarks.replace("\"", "'");
            }
            // Add Swagger annotation to the model field
            field.addJavaDocLine("@Schema(title = \"" + remarks + "\")");
        }
    }

    /**
     * Add JavaDoc comments to a model field
     */
    private void addFieldJavaDoc(Field field, String remarks) {
        // Start JavaDoc
        field.addJavaDocLine("/**");
        // Add database field remarks
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for (String remarkLine : remarkLines) {
            field.addJavaDocLine(" * " + remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }

    /**
     * Add file-level comments for a Java file
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // Only add import for Swagger annotation in model classes, not in Mapper or Example classes
        if (!compilationUnit.getType().getFullyQualifiedName().contains(MAPPER_SUFFIX)
                && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }
}
