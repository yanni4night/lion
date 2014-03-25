<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Freemarker</title>
</head>
<body>
   JSON中数据输出：${name!'找不到'}
   <ul>
   <#if devices??>
   <#list devices as devi>
   <li>${devi}</li>
   </#list>
   </#if>
   </ul>
</body>
</html>
