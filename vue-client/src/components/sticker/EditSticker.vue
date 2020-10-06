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
    <button @click="editSticker" class="btn btn-success">Submit</button>
  </div>
</template>

<script>
  import StickerDataService from "../../services/StickerDataService";

  export default {
    name: "edit-Sticker",
    data() {
      return {
        sticker: {
          id: null,
          title: ""
        }
      };
    },
    methods: {
      editSticker() {
        var data = {
          title: this.sticker.title,
        };

        StickerDataService.update(this.$route.params.id, data)
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