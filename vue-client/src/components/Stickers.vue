<template>
  <div class="list row">
    <div class="col-md-6">
      <AddSticker/>
    </div>
    <div class="col-md-6">
      <h4>Stickers List</h4>
      <div v-if="stickers">
        <ul class="list-group">
          <li class="list-group-item"
              :class="{ active: index === currentIndex }"
              v-for="(sticker, index) in stickers"
              :key="index"
              @click="setActiveSticker(sticker, index)"
          >
            {{ sticker.title }}
          </li>
        </ul>
      </div>
    </div>
    <div class="col-md-6">
      <div v-if="currentSticker">
        <h4>Sticker</h4>
        <div>
          <label><strong>Title:</strong></label> {{ currentSticker.title }}
        </div>

        <a class="badge badge-warning"
           :href="'/stickers/' + currentSticker.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br/>
        <p>Please click on a Sticker...</p>
      </div>
    </div>
  </div>
</template>

<script>
  import StickerDataService from "../services/StickerDataService";
  import AddSticker from "./AddSticker";

  export default {
    components: {
      AddSticker
    },
    name: "stickers-list",
    props: ['currentBoard'],
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
        console.log('refreshList - ' + this.currentBoardId);
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
      console.log('mounted fetchData' + this.currentBoardId);
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