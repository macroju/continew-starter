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

package top.charles7c.continew.starter.extension.crud.model.resp;

import cn.hutool.core.date.DateUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

/**
 * 响应信息
 *
 * @author Charles7c
 * @since 1.0.0
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "响应信息")
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** 是否成功 */
    @Schema(description = "是否成功", example = "true")
    private boolean success;

    /** 业务状态码 */
    @Schema(description = "业务状态码", example = "200")
    private int code;

    /** 业务状态信息 */
    @Schema(description = "业务状态信息", example = "操作成功")
    private String msg;

    /** 响应数据 */
    @Schema(description = "响应数据")
    private T data;

    /** 时间戳 */
    @Schema(description = "时间戳", example = "1691453288")
    private long timestamp = DateUtil.currentSeconds();

    /** 成功状态码 */
    private static final int SUCCESS_CODE = HttpStatus.OK.value();
    /** 失败状态码 */
    private static final int FAIL_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private R(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return new R<>(true, SUCCESS_CODE, "操作成功", null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(true, SUCCESS_CODE, "操作成功", data);
    }

    public static <T> R<T> ok(String msg) {
        return new R<>(true, SUCCESS_CODE, msg, null);
    }

    public static <T> R<T> ok(String msg, T data) {
        return new R<>(true, SUCCESS_CODE, msg, data);
    }

    public static <T> R<T> fail() {
        return new R<>(false, FAIL_CODE, "操作失败", null);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(false, FAIL_CODE, msg, null);
    }

    public static <T> R<T> fail(T data) {
        return new R<>(false, FAIL_CODE, "操作失败", data);
    }

    public static <T> R<T> fail(String msg, T data) {
        return new R<>(false, FAIL_CODE, msg, data);
    }

    public static <T> R<T> fail(int code, String msg) {
        return new R<>(false, code, msg, null);
    }
}
