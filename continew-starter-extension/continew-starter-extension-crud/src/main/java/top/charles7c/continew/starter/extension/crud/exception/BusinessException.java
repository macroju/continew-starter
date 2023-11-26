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

package top.charles7c.continew.starter.extension.crud.exception;

import lombok.NoArgsConstructor;
import top.charles7c.continew.starter.core.exception.BaseException;

/**
 * 业务异常
 *
 * @author Charles7c
 * @since 1.0.0
 */
@NoArgsConstructor
public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(message);
    }
}
