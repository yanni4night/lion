<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Freemarker</title>
<script type="application/javascript"></script>
<style type="text/css"></style>
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
