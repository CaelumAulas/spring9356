function doesNothing(){return!1}function disableActionForSeconds(t,n,e){t.data("interacted",!0),t.on(n,doesNothing),setTimeout(function(){t.unbind(n,doesNothing),t.removeData("interacted")},1e3*e)}$("button, .button, a").on("click",function(t){var n=$(this);n.data("interacted")&&t.preventDefault(),disableActionForSeconds(n,"click",5)}),$("form").on("submit",function(t){$(this).data("interacted")&&t.preventDefault(),disableActionForSeconds($(this),"submit",5)});