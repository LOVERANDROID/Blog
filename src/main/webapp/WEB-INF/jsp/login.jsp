<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">登录</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="loginForm" method="post">
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> 记住密码
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button class="btn btn-default" id="loginBtn">登录</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div>
                    <span>没有账号？立即注册</span>
                </div>
            </div>
        </div>
    </div>
</div>