<template>
  <div id="ansur">
    <el-container>

      <el-header>
        <el-row :gutter="20">
          <el-col :span="6">
            <a href="#" @click.prevent="assetsList()" style="text-decoration: none;">
              <h1 id="logo">Ansur's</h1>
            </a>
          </el-col>
          <!-- <el-col :span="4" :offset="14">
            <el-row  v-if="loginStatus">
              <a href="#" @click.prevent="logoutUser()" style="text-decoration: none;">
                <h4 id="logo">Logout</h4>
              </a>
            </el-row>
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
  name: 'Ansuru',
  data:function() {
    return {
      
    } 
  },
  mounted() {
    
  },
  methods: {
    assetsList() {
      if (this.$store.state.loginStatus == true ) {
        this.$router.push({path: '/assets-list'})
      } else {
        this.$router.push({path: '/'})
      }
    }
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
