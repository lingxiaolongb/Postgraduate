$(function() {




    $("#stu_register").click(function() {
        var $stuRe = createStuNode();
        $("#calei").append($stuRe);
    });

    $("#calei").on("click", ".close", function() {

        $(this).parents(".mask").remove();

    });
    $("#calei").on("click", "#clearNode", function() {
        $(this).parents(".mask").remove();

    });

    $("#sch_register").click(function() {
        var $schRe = createSchNode();
        $("#calei").append($schRe);
    });





    function createStuNode() {

        var $stuRe = $(
            `<div class="mask">
		<div class="stu_main">
			<h2 >考生注册</h2>
			<span class="close"></span>
		    <div>
		    
				<dl class="item">
					<dt class="tit"><span class="must">*</span>用户名:</dt>
					<dd class="tc"><input type="text" class="ipt" id="stu_loginName"  autocomplete="off" name="loginName" />
					<p class="wr_mes" id="wr_mes_name">
					用户名可以包含中文、英文、数字、下划线、4-18个字符</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>密码:</dt>
					<dd class="tc"><input type="password" class="ipt" id="stu_password" autocomplete="off" name="password" />
					<p class="wr_mes" id="wr_mes_pwd">6~16个字符，区分大小写</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>确认密码:</dt>
					<dd class="tc"><input type="password" class="ipt" id="stu_re_password" autocomplete="off" />
					<p class="wr_mes" id="wr_mes_re_pwd">请再次填写密码</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>考号:</dt>
					<dd class="tc"><input type="text" class="ipt" id="stu_uno"  autocomplete="off" name="uno" />
						<p class="wr_mes" id="wr_mes_uno">请输入准考证号</p>
					</dd>
				</dl>
				<br />
				 <dl class="item">
					<dt class="tit"><span class="must">*</span>姓名:</dt>
					<dd class="tc"><input type="text" class="ipt"  id="stu_uname" autocomplete="off" name="uname" />
						<p class="wr_mes" id="wr_mes_uname">请填写你的姓名</p>
					</dd>
				</dl>
				<br /> 
				
			 	<input type="text" id="role" name="roles" value="Student"> 
		
				<dl class="item">
					<dt class="tit"><span class="must">*</span>联系方式:</dt>
					<dd class="tc"><input type="text" class="ipt" id="stu_uphone" autocomplete="off" name="uphone" />
					<p class="wr_mes" id="wr_mes_uphone">请输入手机号码</p>	
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>邮箱:</dt>
					<dd class="tc"> <input type="text" class="ipt ipt_e" id="stu_email" autocomplete="off" name="email" />
					@
					<select id="domain">
						<option>qq.com</option>
						<option>163.com</option>
						<option>yeah.net</option>
					</select>
					<p class="wr_mes" id="wr_mes_email">请输入的邮箱账号</p>	
				</dd>
		
				</dl>
				<br/>
				<dl class="item">
					<dt class="tit">备注:</dt>
					<dd class="tc"><input type="text" class="ipt" name="remarks"  id="stu_remark" autocomplete="off" /></dd>
				</dl>
				
				<div class="stu_btn">
				<input  type="button" value="Cancel" id="clearNode"  />
				<input  type="submit" id="stu_btn"  value="OK" />
				</div>
			</div>
		</div>
	</div>`
        );



        return $stuRe;

    }


    function createSchNode() {
        var $schRe = $(
            `
				<div class="mask">
			<div class="stu_main">
			<h2 >高校注册</h2>
			<span class="close"></span>
		        <div >
				<dl class="item">
					<dt class="tit"><span class="must">*</span>用户名:</dt>
					<dd class="tc"><input type="text" class="ipt" id="stu_loginName"  autocomplete="off" name="loginName" />
					<p class="wr_mes" id="wr_mes_name">
					用户名可以包含中文、英文、数字、下划线、4-18个字符</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>密码:</dt>
					<dd class="tc"><input type="password" class="ipt" id="stu_password" autocomplete="off" name="password" />
					<p class="wr_mes" id="wr_mes_pwd">6~16个字符，区分大小写</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>确认密码:</dt>
					<dd class="tc"><input type="password" class="ipt" id="stu_re_password" autocomplete="off" />
					<p class="wr_mes" id="wr_mes_re_pwd">请再次填写密码</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>学校代码:</dt>
					<dd class="tc"><input type="text" class="ipt" id="stu_uno"  autocomplete="off" name="uno" />
						<p class="wr_mes" id="wr_mes_uno">请输入准考证号</p>
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>姓名:</dt>
					<dd class="tc"><input type="text" class="ipt"  id="stu_uname" autocomplete="off" name="uname" />
						<p class="wr_mes" id="wr_mes_uname">请填写你的姓名</p>
					</dd>
				</dl>
				<br /> 
				
				<input type="text" id="role" name="role" value="School"> 

				<dl class="item">
					<dt class="tit"><span class="must">*</span>联系方式:</dt>
					<dd class="tc"><input type="text" class="ipt" id="stu_uphone" autocomplete="off" name="uphone" />
					<p class="wr_mes" id="wr_mes_uphone">请输入手机号码</p>	
					</dd>
				</dl>
				<br />
				<dl class="item">
					<dt class="tit"><span class="must">*</span>邮箱:</dt>
					<dd class="tc"> <input type="text" class="ipt ipt_e" id="stu_email" autocomplete="off" name="email" />
					@
					<select id="domain">
						<option>qq.com</option>
						<option>163.com</option>
						<option>yeah.net</option>
					</select>
					<p class="wr_mes" id="wr_mes_email">请输入的邮箱账号</p>	
				</dd>

				</dl>
				<br/>
				<dl class="item">
					<dt class="tit">备注:</dt>
					<dd class="tc"><input type="text" class="ipt" name="remarks" id="stu_remark" autocomplete="off" /></dd>
				</dl>
				
				<div class="stu_btn">
				<input  type="button" value="Cancel" id="clearNode" />
				<input  type="submit" id="stu_btn"  value="OK" />
				</div>
		</div>
		</div>
		</div>`
        )

        return $schRe;

    }


});
