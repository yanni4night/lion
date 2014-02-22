<div class="header w-fil">
	<div class="fl bo h-fil logo"><span style="font-family:cursive,arial,sans-serif;">lion</span>/<span class="p18">${subTitle}</span></div>
	<ul class="p24 fl h-fil">
		<#assign links=[['/index.m','Template'],['/static.m','Static'],['/help.m','Help']]>
		<#list links as k>
		<li class="fl bo"><a href="${k[0]}" class="block<#if subTitle==k[1]> on</#if>">${k[1]}</a></li>
		</#list>
	</ul>
</div>