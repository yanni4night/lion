
<#include "common/top.ftl">

    <#assign subTitle="Template">
    
    <#include "common/header.ftl">
    
        <div class="menu h-fil fl bg">
            <a href="javascript:;" class="block" data-menu="main" style='color:#333;background-color: #f5f5f5'>MAIN &gt;&gt;</a>
            <a href="javascript:;" class="block" data-menu="module">MODULE &gt;&gt;</a>
            <a href="javascript:;" class="block" data-menu="common">COMMON &gt;&gt;</a>
        </div>

    <div class="canvas">
        <div class="section" id="section-main"> 
             <ul class="tlist">
                            <#list  tpls as tpl>
                            <li>
                                <a class="title" href="${tpl}.ut">${tpl}.ftl</a>
                                <a class="mgr" href="${tpl}.data">data</a>
                            </li>
                            </#list>
                        </ul></div>
        <div class="section" id="section-module" style="display:none">
              <ul class="tlist">
                            <#list module_tpls as tpl>
                            <li>
                                <a class="title" href="${tpl}.ut">${tpl}.ftl</a>
                                <a class="mgr" href="${tpl}.data">data</a>
                            </li>
                            </#list>
                </ul></div>
        <div class="section" id="section-common" style="display:none">
            <ul class="tlist">
                            <#list common_tpls as tpl>
                            <li>
                                <a class="title" href="${tpl}.ut">${tpl}.ftl</a>
                                <a class="mgr" href="${tpl}.data">data</a>
                            </li>
                            </#list>
            </ul></div>
        </div>

<#include "common/bottom.ftl">