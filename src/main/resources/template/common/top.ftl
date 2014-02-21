<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="author" content="yanni4night@gmail.com"/>
    <meta name="robots" content="nofollow"/>
    <title>lion -- Front End Development</title>
    <script>
    var Selectors = {
    cache: {},
    store: function(selector, element) {
        if(!this.cache[selector])
            this.cache[selector]=[];
        this.cache[selector].push(element);
        element.runtimeStyle.behavior = "none";
    }
}
</script>
    <style type="text/css" >
/*common*/
*{ margin:0; padding:0; }
html,body{ background:#f5f5f5; color:#888686; font:18px/1.6 arial,sans-serif; }
ul,ol,li{list-style: none;}
a:link,a:visited,a:active{color: #888686;text-decoration: none;}
a:hover{color: #333;}
.p24{font-size: 24px;}
.p18{font-size: 18px;}
.p16{font-size: 16px;}
.p14{font-size: 14px;}
.p12{font-size: 12px;}
.p9{font-size: 9px;}
.fl{float: left;}
.lh25{line-height: 25px;}
.tc{text-align: center;}
.hide{display: none !important;}
.block{display: block;}
.fz0{font-size: 0;}
.w-fix { width: 96%; display: block; }
.w-cen { margin: 0 auto; }
.w-fix.w-cen{ margin-left:2%; }
.w-fil { width: 100%; }
.h-fil { height: 100%; }
.w-haf { width: 50%; }
.h-haf { height: 50%; }
.w-wbg { background-color: #fff; }
.t-ell { overflow: hidden; text-overflow:ellipsis;white-space: nowrap;}
.c-fot { color:#000; }
.c-fot:visited { color: #000; }
.cf:after { display: block; visibility: hidden; clear: both; height: 0; content:""; font-size: 0; }
.section{behavior: expression(Selectors.store(".section", this));}
.bg{background: rgb(200,200,200);background: rgba(200,200,200,0.7);}
ul.tlist{margin:0 5px 0 10px;}
.tlist li{background: rgb(200,200,200);background: rgba(200,200,200,0.7);height: 40px;line-height: 40px;text-indent: 2em;font-size: 25px;border-bottom: 1px solid #ddc;}
a.mgr{font-size: 18px;}

.header{position: fixed;_position:absolute;left: 0;top: 0;height: 50px;line-height: 50px;background-color:#c8c8c8;background-color: rgba(200,200,200,0.7);font-size: 30px;border-top: 1px solid #ccc;z-index: 1000;}
.header .logo{width: 200px;}
.header .bo{margin-left: 1em;}
.header a{padding: 0 0.5em;}
.header a:hover,.header a.on{background-color:#f5f5f5 ;background-color:rgba(245,245,245,1) ;}
.menu{width:200px;padding: 10px;padding-right: 0;position: fixed;_position:absolute;top: 55px;left: 0;}
.menu a{height: 40px;line-height: 40px;font-size: 25px;text-indent: 10px;border-bottom: 1px solid #ddc;behavior: expression(Selectors.store(".menu-a", this));}
.canvas{margin-left: 210px;min-width: 960px;_width:960px;position: relative;top:55px;}
</style>
</head>
<body>