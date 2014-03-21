<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Freemarker</title>
</head>
<body>
   JSON中数据输出：${name}
   <ul>
   <#list devices as devi>
   <li>${devi}</li>
   </#list>
   </ul>
</body>
</html>
