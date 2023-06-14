const {
  addCategoryHandler,
  deleteCategoryHandler,
  updateCategoryHandler,
  getCategoryHandler,
  addOrderHandler,
  getOrderHandler,
  addPaymentHandler,
  getPaymentHandler,
  updatePaymentHandler,
  deletePaymentHandler,
  addInvoiceHandler,
  getInvoiceHandler,
  updateInvoiceHandler,
  deleteInvoiceHandler,
  getRatingHandler,
  addRatingHandler,
  updateRatingHandler,
  deleteRatingHandler,
  getRecommendationHandler,
  addRecommendationHandler,
  updateRecommendationHandler,
  deleteRecommendationHandler
} = require('./handler')

const routes = [
  {
    method: 'POST',
    path: '/category',
    handler: addCategoryHandler
  },
  {
    method: 'PUT',
    path: '/category/{id}',
    handler: updateCategoryHandler
  },
  {
    method: 'DELETE',
    path: '/category/{id}',
    handler: deleteCategoryHandler
  },
  {
    method: 'GET',
    path: '/category',
    handler: getCategoryHandler
  },
  {
    method: 'POST',
    path: '/order',
    handler: addOrderHandler
  },
  {
    method: 'GET',
    path: '/order',
    handler: getOrderHandler
  },
  {
    method: 'POST',
    path: '/payment',
    handler: addPaymentHandler
  },
  {
    method: 'GET',
    path: '/payment',
    handler: getPaymentHandler
  },
  {
    method: 'PUT',
    path: '/payment/{id}',
    handler: updatePaymentHandler
  },
  {
    method: 'DELETE',
    path: '/payment/{id}',
    handler: deletePaymentHandler
  },
  {
    method: 'POST',
    path: '/invoice',
    handler: addInvoiceHandler
  },
  {
    method: 'GET',
    path: '/invoice',
    handler: getInvoiceHandler
  },
  {
    method: 'PUT',
    path: '/invoice/{id}',
    handler: updateInvoiceHandler
  },
  {
    method: 'DELETE',
    path: '/invoice/{id}',
    handler: deleteInvoiceHandler
  },
  {
    method: 'GET',
    path: '/rating',
    handler: getRatingHandler
  },
  {
    method: 'POST',
    path: '/rating',
    handler: addRatingHandler
  },
  {
    method: 'PUT',
    path: '/rating/{id}',
    handler: updateRatingHandler
  },
  {
    method: 'DELETE',
    path: '/rating/{id}',
    handler: deleteRatingHandler
  },
  {
    method: 'GET',
    path: '/recommendation',
    handler: getRecommendationHandler
  },
  {
    method: 'POST',
    path: '/recommendation',
    handler: addRecommendationHandler
  },
  {
    method: 'PUT',
    path: '/recommendation/{id}',
    handler: updateRecommendationHandler
  },
  {
    method: 'DELETE',
    path: '/recommendation/{id}',
    handler: deleteRecommendationHandler
  }
]

module.exports = routes
