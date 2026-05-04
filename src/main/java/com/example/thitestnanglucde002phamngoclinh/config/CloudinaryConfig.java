package com.example.thitestnanglucde002phamngoclinh.config;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    private String cloudName = "linh123";

    private String apiKey = "152922968893657";

    private String apiSecret = "zEf-4lyxxrPqJc1TNe5pBOwL3s4";

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name",cloudName,
                        "api_key",apiKey,
                        "api_secret",apiSecret
                )
        );
    }

}

