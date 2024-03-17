import IntroductionVeiw from '@/views/IntroductionVeiw.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/HomeView.vue'),
      children: [
        {
          path: '/intro',
          name: 'intro',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: IntroductionVeiw
        },
        {
          path: '/login',
          name: 'login',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: () => import('../views/LoginView.vue')
        },
        {
          path: '/register',
          name: 'register',
          // route level code-splitting
          // this generates a separate chunk (About.[hash].js) for this route
          // which is lazy-loaded when the route is visited.
          component: () => import('../views/RegisterView.vue')
        },
      ]
    },
    
    {
      path: '/main',
      name: 'main',
      component: () => import('../views/MainView.vue')
    },
  ]
})

export default router
