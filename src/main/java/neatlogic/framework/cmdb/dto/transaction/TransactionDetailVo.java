/*
 * Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.dto.transaction;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

public class TransactionDetailVo {

    private TransactionVo transaction;

    private JSONArray detail;
    @EntityField(name = "允许恢复", type = ApiParamType.BOOLEAN)
    private boolean allowRecover;

    public TransactionDetailVo() {
    }

    public TransactionDetailVo(TransactionVo transaction, JSONArray detail, boolean allowRecover) {
        this.transaction = transaction;
        this.detail = detail;
        this.allowRecover = allowRecover;
    }

    public TransactionVo getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionVo transaction) {
        this.transaction = transaction;
    }

    public JSONArray getDetail() {
        return detail;
    }

    public void setDetail(JSONArray detail) {
        this.detail = detail;
    }

    public boolean getAllowRecover() {
        return allowRecover;
    }

    public void setAllowRecover(boolean allowRecover) {
        this.allowRecover = allowRecover;
    }
}
