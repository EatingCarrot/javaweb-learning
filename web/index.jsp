<%--
  Created by IntelliJ IDEA.
  User: qiyuewen
  Date: 2024/9/10
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <link href="css/bootstrap-icons.min.css" rel="stylesheet" crossorigin="anonymous">
</head>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .header {
        width: 100%;
        border-bottom: 1px solid #aaa;
    }

    .action {
        padding: 20px 220px;
        display: flex;
        width: 100%;
        height: 30px;
    }

    .action span {
        height: 33px;
        margin-right: 20px;
        line-height: 2;
        font-size: 12px;
        color: #767676;
    }
    .action span:last-child{
        margin-right: 0;
    }

    .navigation {
        font-weight: 600;
        margin: 0 150px;
        display: flex;
        height: 80px;
    }

    .login {
        margin-left: auto;
    }

    .logo {
        padding-left: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100px;
    }

    .search {
        margin-left: 100px;
        display: flex;
        justify-content: center;
        align-items: center;
        width: 240px;
        position: relative;
    }

    .write {
        width: 100px;
        font-size: 16px;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .navigator {
        display: flex;
        justify-content: start;
        align-items: center;
    }

    ul {
        margin: 0 !important;
    }

    li {
        width: 95px;
        height: 100%;
        list-style: none;
        display: flex;
        justify-content: center;
        align-items: center;

    }

    li:hover {
        transition: .3s;
        color:#20c698
    }

    li span {
        margin: auto;
    }

    .search-input {
        flex: 1;
        padding-right: 20px;
    }

    .container {
        padding: 30px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    .form {
        margin-top: 40px;
        width: 500px;

    }
    .right{
        text-align: right;
    }
    .search-icon{
        position: absolute;
        right: 10px;
    }
    .logo img{
        width: 100px;
    }
    /* body{
        background-image: url(https://ys.mihoyo.com/main/_nuxt/img/poster.47f71d4.jpg);
        background-size: cover;
    } */
</style>

<body>
<div class="header">
    <div class="action">

        <span class="login">登录</span>
        <span>注册</span>
        <span>购书单</span>
    </div>
    <div class="navigation">
        <div class="logo">
            <img src="data:image/jpeg;base64,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"/>
        </div>
        <ul class="navigator">
            <li>
                <span>首页</span>
            </li>
            <li><span>新闻</span></li>
            <li><span>世界</span></li>
            <li><span>漫画</span></li>
            <li><span>社区</span></li>
            <li><span>赛事</span></li>
        </ul>
        <div class="search">
            <input class="search-input form-control" type="text" name="search" />
            <i class="bi bi-search search-icon"></i>
        </div>
        <div class="write">
            <span>启动</span>
        </div>
    </div>
</div>
<div class="container">

    <h1>注册就送1000原石！</h1>
    <form class="form-horizontal form" role="form">
        <div class="mb-3 row">
            <label for="username" class="col-sm-3 col-form-label right">用户名</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="username" placeholder="用户名">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputPassword" class="col-sm-3 col-form-label right">密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" id="inputPassword" placeholder="密码">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="inputPassword2" class="col-sm-3 col-form-label right">确认密码</label>
            <div class="col-sm-9">
                <input type="password" class="form-control" id="inputPassword2" placeholder="确认密码">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="tel" class="col-sm-3 col-form-label right">手机</label>
            <div class="col-sm-9">
                <input type="text" class="form-control" id="tel" placeholder="手机">
            </div>
        </div>
        <div class="mb-3 row">
            <label for="code" class="col-sm-3 col-form-label right" >短信验证码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="code" placeholder="短信验证码">
            </div>
            <div class="col-sm-3">
                <button type="button" class="btn btn-outline-success">发送验证码</button>
            </div>
        </div>
        <div class="mb-3 row">
            <div class="col-sm-6 right" ><button type="button" class="btn btn-danger">注册成为老师</button></div>

            <div class="col-sm-6">
                <button type="button" class="btn btn-info">注册成为学生</button>
            </div>
        </div>
    </form>
</div>
</body>

</html>
