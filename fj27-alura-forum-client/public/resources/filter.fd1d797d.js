function filterBy(t,r,o,i){if("todos"==r)return!1;var e=i?$("input[name=restriction]:checked").val()||"todos":"",n=$(location).attr("href"),a=new RegExp(o),c=n.match(a);""===c[2]?n+=t+r+"/"+e:n=n.replace(c[2],t+r+"/"+e),submitForm(n)}function submitForm(t){var r=$(".forumFilter-form");r.attr("action",t),r.submit()}