</body>
<script>

    var bindFunc=function(ele,evt,func){
        if(document.addEventListener){
            ele.addEventListener(evt,func,false);
        }else{
            ele.attachEvent('on'+evt,func);
        }
    };

    var $=function(selector){
        if(document.querySelectorAll)
            return document.querySelectorAll(selector);
        else 
            return Selectors.cache[selector.replace(/\s/g,'-')];
    };

    var preventEventDefault=function(e){
    	if(!e)return;
        ('function'===typeof e.preventDefault)&&e.preventDefault();
        (undefined!==e.returnValue)&&(e.returnValue=false);
    };

    bindFunc(document,'click',function(e){
        e=e||window.event;
        var t=e.srcElement||e.target;
        var menu=null;
        if(menu=t.getAttribute('data-menu')){
            preventEventDefault(e);
            var sections = $('.section');
            for(var i=0,len=sections.length;i<len;++i){
                sections[i].style.display='none'
            }
            document.getElementById('section-'+menu).style.display='block';

            var menuitems = $('.menu a');
            for(var i=0,len=menuitems.length;i<len;++i){
                menuitems[i].style.color='';
                menuitems[i].style.backgroundColor='';
            }
            t.style.color='#333';
            t.style.backgroundColor='#f5f5f5';
        }
    });
</script>
</html>