<script setup>
import ApiService from '@/service/ApiService'
import {ref} from 'vue'
import {useRouter} from 'vue-router'

const router = useRouter()

const name = ref('')
const telephone = ref('');
const password = ref('');
const comfirm_password = ref('')
const registerFail = ref(false)
const registerSuccess = ref(false)

const registerUser = async () => {

  try {
    const response = await ApiService.post('register', 
      {
        userName: name.value,
        telephone: telephone.value,
        password: password.value,
        matchingPassword: comfirm_password.value
    });
    console.log(response);
    registerSuccess.value = true;
    setTimeout(() => {
      // router.push('/login')
      router.push('/login')
    }, 1000) //
    console.log('123');
  } catch (error) {
    console.error(error); 
    registerFail.value = true;
  }
}

</script>

<template>
  <div class="Register">
    <!-- <h2>Login</h2> -->
    <form @submit.prevent="registerUser">
      <!-- <div class="container">  
        <div class="input-container"> 
          <label><b>Telephone No.</b></label>  
          <input type="telphone" id="inputTelphone" class="form-control" placeholder="Enter Telphone No." required> -->
          <!-- <i class="fas fa-envelope"></i> -->
        <!-- </div> 
      </div>  -->
      <input type="neme" v-model="name" id="inputName" class="form-control" placeholder="Username" required="true" >
      <input type="telphone" v-model="telephone" id="inputTelphone" class="form-control" placeholder="Telphone No." required="true" >
      <input type="password" v-model="password" id="inputPassword" class="form-control" placeholder="Password" required="true">
      <input type="password" v-model="comfirm_password" id="comfirmPassword" class="form-control" placeholder="Comfirm Password" required="true">
      <button type="submit">Register</button>
      <p v-if="registerFail&& !registerSuccess" class="error"> Register failed.<br>Phone number already registered.</p>
      <p v-if="registerSuccess" class="error"> Register Success.</p>
      <hr>
      <p>Already have an account? <router-link to="/login">Sign In</router-link>.</p>


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
