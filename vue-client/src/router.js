import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    /*{
      path: "/",
      alias: "/boards",
      name: "boards",
      component: () => import("./components/Boards")
    },*/
    {
      path: "/",
      alias: "/main",
      name: "main",
      component: () => import("./components/Main")
    },
    {
      path: "/boards/:id",
      name: "board-details",
      component: () => import("./components/Board")
    },
    {
      path: "/boards/:id/stickers",
      name: "stickers",
      component: () => import("./components/Stickers")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("./components/AddBoard")
    },
    {
      path: "/addSticker",
      name: "addSticker",
      component: () => import("./components/AddSticker")
    }
  ]
});