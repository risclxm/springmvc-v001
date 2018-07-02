<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-content">
				<form method="post" id="user_form" name="user_form"
					enctype="multipart/form-data">
					<div class="form-group has-success">
						<label class="control-label" for="user_name">图片标题:</label> <input
							type="hidden" name="id" id="id" /> <input type="text"
							class="form-control col-lg-2" id="title" name="title">
					</div>

					<div class="form-group has-success">
						<label class="control-label" for="selectError">图片:</label>
						<div class="controls">
							<div id="pic">
								<img id="imageFrontOld" class="thumbnail" height="80px"
									width="120px" src="" />
							</div>
							<input type="file" id="zm" name="myfiles"
								class="form-control col-lg-2" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
 	 $(function () {
        $('form').bootstrapValidator({
　　　　　　　　 message: 'This value is not valid',
            　	   feedbackIcons: {
                　　　　　　　　valid: 'glyphicon glyphicon-ok',
                　　　　　　　　invalid: 'glyphicon glyphicon-remove',
                　　　　　　　　validating: 'glyphicon glyphicon-refresh'
            　　　　　　　　   },
            fields: {
                title: {
                    message: '图片标题验证失败',
                    validators: {
                        notEmpty: {
                            message: '图片标题不能为空'
                        }
                    }
                }
               
            },
            submitHandler: function(validator, form, submitButton) {  
                validator.defaultSubmit();  
            }
        });
    });
  
   
 </script>