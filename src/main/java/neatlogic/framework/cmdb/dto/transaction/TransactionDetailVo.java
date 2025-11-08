/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
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
