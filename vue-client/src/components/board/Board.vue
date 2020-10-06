<template>
  <div v-if="currentBoard" class="edit-form">
    <h4>Board</h4>
    <form>
      <div class="form-group">
        <label for="title">Title</label>
        <input type="text" class="form-control" id="title"
               v-model="currentBoard.title"
        />
      </div>
    </form>

    <button class="badge badge-danger mr-2"
            @click="deleteBoard"
    >
      Delete
    </button>

    <button type="submit" class="badge badge-success"
            @click="updateBoard"
    >
      Update
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Please click on a Board...</p>
  </div>
</template>

<script>
  import BoardDataService from "../../services/BoardDataService";

  export default {
    name: "board",
    data() {
      return {
        currentBoard: null,
        message: ''
      };
    },
    methods: {
      getBoard(id) {
        BoardDataService.get(id)
        .then(response => {
          this.currentBoard = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      updateBoard() {
        BoardDataService.update(this.currentBoard.id, this.currentBoard)
        .then(response => {
          console.log(response.data);
          this.message = 'The board was updated successfully!';
        })
        .catch(e => {
          console.log(e);
        });
      },

      deleteBoard() {
        BoardDataService.delete(this.currentBoard.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "tutorials" });
        })
        .catch(e => {
          console.log(e);
        });
      }
    },
    mounted() {
      this.message = '';
      this.getBoard(this.$route.params.id);
    }
  };
</script>

<style>
  .edit-form {
    max-width: 300px;
    margin: auto;
  }
</style>