<template>
  <div id="ansur">
    <el-container>

      <el-header>
        <el-row :gutter="20">
          <el-col :span="6">
            <router-link to="/" id="rlink">
              <h1 id="logo">Ansur's</h1>
            </router-link>
          </el-col>
          <el-col :span="2">
            <router-link to="/login" id="rlink"><h4>Login</h4></router-link>
          </el-col>
          <el-col :span="2">
            <router-link to="/signup" id="rlink"><h4>Signup</h4></router-link>
          </el-col>
          <!-- <el-col :span="3" :offset="11">
            <router-link to="/user-guide" id="rlink"><h4>User Guide</h4></router-link>
          </el-col> -->
        </el-row>
        
      </el-header>

      <el-main>
        <router-view></router-view>
      </el-main>

      <!-- <el-footer id="footer">
        Ansuru@Footer
      </el-footer> -->
    </el-container>
  </div>
</template>

<script>

</script>

<style scoped>
  #logo {
    color: red;
  }
  #footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: #66b1ff;
    color: black;
    text-align: center;
    padding: 20px;
  }
  #rlink {
    text-decoration: none;
    color: #499bed;
  }
</style>
