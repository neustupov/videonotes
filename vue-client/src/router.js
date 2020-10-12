import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/main",
      name: "main",
      component: () => import("./components/Main")
    },
    {
      path: "/boards/:id",
      name: "board-details",
      component: () => import("./components/board/Board")
    },
    {
      path: "/boards/:id/stickers",
      name: "stickers",
      component: () => import("./components/sticker/Stickers")
    },
    {
      path: "/addBoard",
      name: "addBoard",
      component: () => import("./components/board/AddBoard")
    },
    {
      path: "/editBoard/:id",
      name: "editBoard",
      component: () => import("./components/board/EditBoard")
    },
    {
      path: "/addSticker/:id",
      name: "addSticker",
      component: () => import("./components/sticker/AddSticker")
    },
    {
      path: "/editSticker/:id",
      name: "editSticker",
      component: () => import("./components/sticker/EditSticker")
    },
    {
      path: "/addNote/:id",
      name: "addNote",
      component: () => import("./components/note/AddNote")
    },
    {
      path: "/editNote/:id",
      name: "editNote",
      component: () => import("./components/note/EditNote")
    }
  ]
});