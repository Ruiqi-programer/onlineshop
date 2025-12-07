package com.peng.sms;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Code generator for MyBatis Generator (MBG)
 */
public class Generator {
    public static void main(String[] args) throws Exception {
        // Warnings generated during MBG execution
        List<String> warnings = new ArrayList<>();
        // Overwrite existing code if generated code already exists
        boolean overwrite = true;
        // Read MBG configuration file
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        // Create MBG instance
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // Execute code generation
        myBatisGenerator.generate(null);
        // Print warnings, if any
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
