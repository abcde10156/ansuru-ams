<template>
  <div id="ansur">
    <el-container>

      <el-header>
        <el-row :gutter="20">
          <el-col :span="6">
            <router-link to="/" id="rlink">
              <h2 id="logo">Ansur's</h2>
            </router-link>
          </el-col>
          <!-- <el-col :span="2" v-if="!adminLogin && !userLogin">
            <router-link to="/user-login" id="rlink"><h4>Login</h4></router-link>
          </el-col>
          <el-col :span="2" v-if="!adminLogin && !userLogin">
            <router-link to="/user-signup" id="rlink"><h4>Signup</h4></router-link>
          </el-col>
          <el-col :span="2" v-if="adminLogin || userLogin">
            <router-link to="/logout" id="rlink"><h4>Signup</h4></router-link>
          </el-col>
          <el-col :span="3" :offset="11" style="margin-top: 20px;">
            <el-row v-if="!adminLogin" style="margin-bottom: 10px; text-align: right;">
              <router-link to="/item-register">
                <el-button type="primary" size="medium">
                  + Add New Item
                </el-button>
              </router-link>
            </el-row>
          </el-col> -->
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
export default {
  name: 'Signup',
  data:function() {
    return {
      userLogin: false,
      adminLogin: false,
    } 
  },
  methods: {
    
  },
}
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
