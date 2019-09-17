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
