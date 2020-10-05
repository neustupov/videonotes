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
      path: "/addBoard",
      name: "addBoard",
      component: () => import("./components/AddBoard")
    },
    {
      path: "/editBoard/:id",
      name: "editBoard",
      component: () => import("./components/EditBoard")
    },
    {
      path: "/addSticker/:id",
      name: "addSticker",
      component: () => import("./components/AddSticker")
    },
    {
      path: "/editSticker/:id",
      name: "editSticker",
      component: () => import("./components/EditSticker")
    }
  ]
});