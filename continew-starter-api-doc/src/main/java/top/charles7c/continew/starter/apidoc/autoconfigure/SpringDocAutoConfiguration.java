/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.charles7c.continew.starter.apidoc.autoconfigure;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import top.charles7c.continew.starter.core.autoconfigure.ProjectProperties;

/**
 * API 文档自动配置
 *
 * @author Charles7c
 * @since 1.0.0
 */
@Slf4j
@AutoConfiguration
@ConditionalOnProperty(name = "springdoc.swagger-ui.enabled", havingValue = "true")
public class SpringDocAutoConfiguration {

    /**
     * Open API 配置
     */
    @Bean
    @ConditionalOnMissingBean
    public OpenAPI openApi(ProjectProperties properties) {
        Info info = new Info()
                .title(String.format("%s %s", properties.getName(), "API 文档"))
                .version(properties.getVersion())
                .description(properties.getDescription());
        ProjectProperties.Contact contact = properties.getContact();
        if (null != contact) {
            info.contact(new Contact().name(contact.getName())
                    .email(contact.getEmail())
                    .url(contact.getUrl()));
        }
        ProjectProperties.License license = properties.getLicense();
        if (null != license) {
            info.license(new License().name(license.getName())
                    .url(license.getUrl()));
        }
        return new OpenAPI().info(info);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("[ContiNew Starter] - Auto Configuration 'ApiDoc' completed initialization.");
    }
}