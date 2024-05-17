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

package neatlogic.framework.cmdb.dataconversion;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.cmdb.dto.transaction.CiEntityTransactionVo;
import neatlogic.framework.common.RootComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RootComponent
public class DataConversionPostProcessorFactory extends ModuleInitializedListenerBase {

    private static final List<IDataConversionPostProcessor> dataConversionPostProcessorList = new ArrayList<>();

    public static void invokeDataConversionPostProcessors(String ciName, List<CiEntityTransactionVo> ciEntityTransactionList, Long transactionGroupId) {
        for (IDataConversionPostProcessor dataConversionPostProcessor : dataConversionPostProcessorList) {
            dataConversionPostProcessor.postProcessAfterDataConversion(ciName, ciEntityTransactionList, transactionGroupId);
        }
    }

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IDataConversionPostProcessor> map = context.getBeansOfType(IDataConversionPostProcessor.class);
        for (Map.Entry<String, IDataConversionPostProcessor> entry : map.entrySet()) {
            dataConversionPostProcessorList.add(entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }
}
