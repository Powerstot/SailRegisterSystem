<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>admin</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="../css/admin.css">
    <link rel="stylesheet" href="../css/layout.css" type="text/css" media="screen" />
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="../css/ie.css" type="text/css" media="screen" />
    <![endif]-->
    <!--引入图标-->
<%--    <link rel="shortcut icon" href="../favicon.ico"/>--%>
    <script src="../js/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="../js/hideshow.js" type="text/javascript"></script>
    <script src="../js/jquery.tablesorter.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/jquery.equalHeight.js"></script>
    <%--使用ajax异步查找所有成员信息--%>
    <script>
        $(function () {

            $.ajax({
                url:"/findAll",
                type:"POST",
                success:function(data){
                    showData(data);
                },
                error:function(){
                     alert("ajax连接异常");
                }
            });

        })
        //展示所有信息到table内
        function showData(data) {
            var str = "";
            for(var i = 0; i < data.length; i++) {
                str = "<tr><td id='alltd'><img src='../images/" + data[i].lifePhoto +
                    "' style='width: 100px; height: 100px'></td><td id='alltd'>" + data[i].sno +
                    "</td><td id='alltd'>" + data[i].username + "</td><td id='alltd'>" + data[i].classAndGrade +
                    "</td><td id='alltd'>" + data[i].phone + "</td><td id='alltd2'>" + data[i].skills +
                    "</td><td id='alltd2'>" + data[i].reason + "</td></tr>";
                $("#tbody").append(str);
            }
        }
    </script>
    <script type="text/javascript">
        $(document).ready(function() {
                $(".tablesorter").tablesorter();
            }
        );
        $(document).ready(function() {

            //When page loads...
            $(".tab_content").hide(); //Hide all content
            $("ul.tabs li:first").addClass("active").show(); //Activate first tab
            $(".tab_content:first").show(); //Show first tab content

            //On Click Event
            $("ul.tabs li").click(function() {

                $("ul.tabs li").removeClass("active"); //Remove any "active" class
                $(this).addClass("active"); //Add "active" class to selected tab
                $(".tab_content").hide(); //Hide all tab content

                var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
                $(activeTab).fadeIn(); //Fade in the active ID content
                return false;
            });

        });
    </script>
    <script type="text/javascript">
        $(function(){
            $('.column').equalHeight();
        });
    </script>
</head>
<body>

<header id="header">
    <hgroup>
        <h1 class="site_title" style="text-align: center"><a href="NoTimeToWriteAdmin.jsp" >管理项</a></h1>
        <h2 class="section_title">仪表盘</h2>
        <div class="btn_view_site"><a href="../html/enroll.html">报名网站</a></div>
    </hgroup>
</header> <!-- end of header bar -->

<!--<section id="secondary_bar">
    <div class="user">
        <p>John Doe (<a href="#">3 Messages</a>)</p>
        &lt;!&ndash; <a class="logout_user" href="#" title="Logout">Logout</a> &ndash;&gt;
    </div>
    <div class="breadcrumbs_container">
        <article class="breadcrumbs"><a href="index.html">Website Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Dashboard</a></article>
    </div>
</section>&lt;!&ndash; end of secondary bar &ndash;&gt;-->

<aside id="sidebar" class="column">
    <form class="quick_search">
        <input type="text" value="Quick Search" onfocus="if(!this._haschanged){this.value=''};this._haschanged=true;">
    </form>
    <hr/>
    <h3>分类管理</h3>
    <ul class="toggle">
        <li class="icn_categories"><a href="${pageContext.request.contextPath}/adminCategoryServlet">分类列表</a></li>
        <li class="icn_new_article"><a href="./category/add.jsp">添加分类</a></li>
    </ul>
    <h3>用户管理</h3>
    <ul class="toggle">
        <li class="icn_view_users"><a href="${pageContext.request.contextPath}/findAllUserServlet">用户列表</a></li>
        <li class="icn_add_user"><a href="./user/add.jsp">新增用户</a></li>
        <li class="icn_profile"><a href="#">我的信息</a></li>
    </ul>
    <h3>商品管理</h3>
    <ul class="toggle">
        <li class="icn_folder"><a href="${pageContext.request.contextPath}/findAllServlet">商品列表</a></li>
        <li class="icn_new_article"><a href="${pageContext.request.contextPath}/addPUIServlet">添加商品</a></li>
    </ul>
    <h3>订单管理</h3>
    <ul class="toggle">
        <li class="icn_categories"><a href="${pageContext.request.contextPath}/findAllOrdServlet">订单列表</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=0">未付款订单</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=1">已付款订单</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=2">已发货订单</a></li>
        <li class="icn_photo"><a href="${pageContext.request.contextPath}/findAllOrdServlet?state=3">已完成订单</a></li>
    </ul>

    <footer>
        <hr />
        <p><strong>启航实验室注册后台管理</strong></p>
    </footer>
</aside><!-- end of sidebar -->

<section id="main" class="column">

    <h4 class="alert_info">欢迎来到启航实验室注册管理页面。</h4>

    <article class="module width_3_quarter">
        <header><h3 class="tabs_involved">Content Manager</h3>
            <ul class="tabs">
                <li><a href="#tab1">Posts</a></li>
                <li><a href="#tab2">Comments</a></li>
            </ul>
        </header>

        <div class="tab_container">
            <div id="tab1" class="tab_content">
                <table class="tablesorter" cellspacing="0">
                    <thead>
                    <tr>
                        <th>照片</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>班级</th>
                        <th>电话</th>
                        <th>技能</th>
                        <th>原因</th>
                    </tr>
                    </thead>
                    <%--ajax查到的数据拼接进此tbody--%>
                    <tbody id="tbody">

                    </tbody>
                </table>
            </div><!-- end of #tab1 -->
        </div><!-- end of .tab_container -->

    </article><!-- end of content manager article -->

</section>

</body>

</html>