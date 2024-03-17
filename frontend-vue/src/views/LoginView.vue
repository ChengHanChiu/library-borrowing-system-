<script setup>
import ApiService from '@/service/ApiService'
import {ref} from 'vue'
import  router  from '@/router'
import { RouterLink } from 'vue-router'


const telephone = ref('');
const password = ref('');
const loginFail = ref(false);

// const router = useRouter(); 

const loginUser = async () => {
  try {
    const response = await ApiService.get('/login', {
      params: {
        telephone: telephone.value,
        password: password.value
      }
    });
    if (response.status==200){
      router.push('/main')
    };
  } catch (error) {
    console.error(error); 
    loginFail.value = true;
  }
}

</script>

<template>
  <div class="Login">
    <!-- <h2>Login</h2> -->
    <form @submit.prevent="loginUser">
      <!-- <div class="container">  
        <div class="input-container"> 
          <label><b>Telephone No.</b></label>  
          <input type="telphone" id="inputTelphone" class="form-control" placeholder="Enter Telphone No." required> -->
          <!-- <i class="fas fa-envelope"></i> -->
        <!-- </div> 
      </div>  -->
      <input type="telphone" v-model="telephone" id="inputTelphone" class="form-control" placeholder="Telphone No." required="true" >
      <input type="password" v-model="password" id="inputPassword" class="form-control" placeholder="Password" required="true">
      <button type="submit">Login</button>
      <p v-if="loginFail" class="error"> Login failed.<br> Please check your phone number and password.</p>
      <a href="#" v-else>Forgot password?</a>
      <hr>
      <!-- <p>Don't have an account? <a href="/register">Sign Up</a>.</p> -->
      <p>Don't have an account? <router-link to="/register">Sign Up</router-link>.</p>


    </form>
  </div>
</template>

<style scope>
#inputTelphone:before {
  font-family: 'Font Awesome 5 Free';
  content: '\f06a';
  position: absolute;
  left: 10px; /* 调整图标距离左侧的距离 */
  color: #888; /* 调整图标颜色 */
}
/* @media (min-width: 1024px) {
  .Login {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
} */

/* .container {  
    padding: 16px;  
}   */

/* .input-container { 
    position: relative; 
} 
  
.input-container i{ 
    position: absolute; 
    left: 15px; 
    top: 40px; 
    color: gray; 
}  */

form {
  background-color:  rgba(232, 234, 235, 0.619);
  display: flex;
  flex-direction: column;
  max-width: 500px;
  height: 60vh;
  width: 60vw;
  margin: 0 auto;
  padding: 50px;
  /* border: 5px solid hsla(160, 100%, 37%, 1); */
  border-radius: 20px;
}

label {
  margin-bottom: 5px;
}
input {
  margin-bottom: 15px;
  padding: 8px;
} 
button {
  background-color: hsla(160, 100%, 37%, 1);;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
}

.error {
  color: red;
}
</style>
