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
