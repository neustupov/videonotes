import http from "../http-common";

class StickerDataService {
  getAll(id) {
    return http.get(`/boards/${id}/stickers`);
  }

  get(id) {
    return http.get(`/stickers/${id}`);
  }

  create(data) {
    return http.post("/stickers", data);
  }

  update(id, data) {
    return http.put(`/stickers/${id}`, data);
  }

  delete(id) {
    return http.delete(`/stickers/${id}`);
  }

  deleteAll() {
    return http.delete(`/stickers`);
  }

  findByTitle(title) {
    return http.get(`/stickers?title=${title}`);
  }
}

export default new StickerDataService();