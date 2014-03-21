
 <#include "common/top.ftl">

 
    <#assign subTitle="Static">
    <#include "common/header.ftl">

    <div class="menu h-fil fl bg">
        <a href="javascript:;" class="block" data-menu="css" style='color:#333;background-color: #f5f5f5'>CSS &gt;&gt;</a>
        <a href="javascript:;" class="block" data-menu="js">JS &gt;&gt;</a>
        <a href="javascript:;" class="block" data-menu="image">IMAGE &gt;&gt;</a>
    </div>
    <div class="canvas ">
        <div class="section" id="section-css"> <ul class="tlist">
                            <#list css as tpl>
                            <li>
                                <a class="title t-ell" target="_blank" href="/static/css${tpl}">${tpl}</a>
                            </li>
                            </#list>
                        </ul></div>
        <div class="section" id="section-js" style="display:none"><ul class="tlist">
                            <#list js as tpl>
                            <li>
                                <a class="title t-ell" target="_blank" href="/static/js${tpl}">${tpl}</a>
                            </li>
                            </#list>
                        </ul></div>
        <div class="section" id="section-image" style="display:none"> <ul class="tlist">
                            <#list img as tpl>
                            <li>
                                <a class="title t-ell" target="_blank" href="/static/img${tpl}">${tpl}</a>
                            </li>
                            </#list>
                        </ul></div>
                    </div>

<#include "common/bottom.ftl">