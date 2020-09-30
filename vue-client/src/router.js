import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/boards",
      name: "boards",
      component: () => import("./components/BoardsList")
    },
    {
      path: "/boards/:id",
      name: "board-details",
      component: () => import("./components/Board")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("./components/AddBoard")
    }
  ]
});