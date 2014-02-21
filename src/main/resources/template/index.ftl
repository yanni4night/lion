
<#include "common/top.ftl">

    <#assign subTitle="Template">
    
    <#include "common/header.ftl">
    
        <div class="menu h-fil fl bg">
            <a href="javascript:;" class="block" data-menu="main" style='color:#333;background-color: #f5f5f5'>FTL &gt;&gt;</a>
        </div>

    <div class="canvas">
        <div class="section" id="section-main"> 
             <ul class="tlist">
                            <#list  tpls as tpl>
                            <li>
                                <a class="title" target="_blank" href="${tpl}.ut">${tpl}.ftl</a>
                                <a class="mgr" href="${tpl}.data">data</a>
                            </li>
                            </#list>
                        </ul>
        </div>
    </div>

<#include "common/bottom.ftl">