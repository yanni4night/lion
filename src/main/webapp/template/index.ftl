<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Freemarker</title>
</head>
<body>
   ${name}
   <ul>
   <#list devices as devi>
   <li>${devi}</li>
   </#list>
   </ul>
</body>
</html>
