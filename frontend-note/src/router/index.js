import { createRouter, createWebHashHistory } from "vue-router"
import Login from "../views/Note.vue"

export const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: "/login",
            component: Login
        }
    ]
})