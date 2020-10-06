<template>
  <div class="list row">
    <div class="col-md-auto align-self-center">
      <h4>Stickers</h4>
      <div v-if="stickers">
        <ul class="list-group">
          <li class="list-group-item"
              v-for="(sticker, index) in stickers"
              :key="index"
              @click="setActiveSticker(sticker, index)"
          >
            <Sticker :sticker='sticker'/>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
  import StickerDataService from "../services/StickerDataService";
  import Sticker from "./Sticker";

  export default {
    name: "stickers-list",
    props: ['currentBoard'],
    components: {Sticker},
    watch: {
      currentBoard: function (newVal, oldVal) {
        console.log('Prop changed: ', newVal, ' | was: ', oldVal);
        this.currentBoardId = this.currentBoard.board.id;
        console.log(this.currentBoardId);
        this.refreshList();
      }
    },
    data() {
      return {
        stickers: [],
        currentSticker: null,
        currentIndex: -1,
        title: "",
        currentBoardId: this.currentBoard.board.id
      };
    },
    methods: {
      async fetchData() {
        try {
          console.log('fetchData - ' + this.currentBoardId);
          const res = await StickerDataService.getAll(this.currentBoardId);
          this.stickers = res.data;
          return res;
        } catch (e) {
          this.stickers = [];
          console.error(e)
        }
      },

      refreshList() {
        this.currentSticker = null;
        this.currentIndex = -1;
        return this.fetchData();
      },

      setActiveSticker(sticker, index) {
        this.currentSticker = sticker;
        this.currentIndex = index;
      }
    },

    mounted() {
      this.fetchData();
    }
  }
</script>

<style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
</style>