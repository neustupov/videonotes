<template>
  <div class="submit-form">
    <div class="form-group">
      <label for="title">Title</label>
      <input
          type="text"
          class="form-control"
          id="title"
          required
          v-model="sticker.title"
          name="title"
      />
    </div>
    <button @click="saveSticker" class="btn btn-success">Submit</button>
  </div>
</template>

<script>
  import StickerDataService from "../../services/StickerDataService";

  export default {
    name: "add-sticker",
    data() {
      return {
        sticker: {
          id: null,
          title: "",
          notes: [],
          board: null
        }
      };
    },
    methods: {
      saveSticker() {
        var data = {
          title: this.sticker.title,
          boardId: this.$route.params.id
        };

        StickerDataService.create(data)
        .then(response => {
          this.sticker.id = response.data.id;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
      },

      newSticker() {
        this.sticker = {};
      }
    }
  };
</script>

<style>
  .submit-form {
    max-width: 300px;
    margin: auto;
  }
</style>