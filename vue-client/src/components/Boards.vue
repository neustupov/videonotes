<template>
  <div class="list row justify-content-start">
    <div class="col-md-6">
      <h4>Boards List</h4>
      <ul class="list-group list-group-horizontal">
        <li class="list-group-item shadow-lg m-1 p-3 mb-5 rounded"
            :class="{ active: index === currentIndex }"
            v-for="(board, index) in boards"
            :key="index"
            @click="setActiveBoard(board, index)"
        >
          {{ board.title }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  import BoardDataService from "../services/BoardDataService";

  export default {
    name: "boards-list",
    data() {
      return {
        boards: [],
        currentBoard: null,
        currentIndex: -1,
        title: ""
      };
    },
    methods: {
      retrieveBoards() {
        BoardDataService.getAll()
        .then(response => {
          this.boards = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      refreshList() {
        this.retrieveBoards();
        this.currentBoard = null;
        this.currentIndex = -1;
      },

      setActiveBoard(board, index) {
        this.currentBoard = board;
        this.currentIndex = index;
        this.$emit('set-current-board', {
          board: board
        });
      },

      removeAllBoards() {
        BoardDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
      },

      searchName() {
        BoardDataService.findByTitle(this.title)
        .then(response => {
          this.boards = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      }
    },
    mounted() {
      this.retrieveBoards();
    }
  };
</script>

<style>
  .list {
    text-align: left;
    max-width: 750px;
    margin: auto;
  }
</style>