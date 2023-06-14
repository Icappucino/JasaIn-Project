const { category, order, payment, invoice, rating, recommendation } = require('./index')

// API Kategori
const addCategoryHandler = (request, h) => {
  const { id_category, category_name } = request.payload

  const newCategory = {
    id_category,
    category_name
  }

  category.push(newCategory)

  return h.response(newCategory).code(201)
}

const deleteCategoryHandler = (request, h) => {
  const { id } = request.params

  const indexToRemove = category.findIndex((cat) => cat.id_category === parseInt(id))

  if (indexToRemove !== -1) {
    category.splice(indexToRemove, 1)
    return h.response().code(204)
  }

  return h.response().code(404)
}

const updateCategoryHandler = (request, h) => {
  const { id } = request.params
  const { category_name } = request.payload

  const indexToUpdate = category.findIndex((cat) => cat.id_category === parseInt(id))

  if (indexToUpdate !== -1) {
    category[indexToUpdate].category_name = category_name
    return h.response(category[indexToUpdate]).code(200)
  }

  return h.response().code(404)
}

const getCategoryHandler = (request, h) => {
  return h.response(category).code(200)
}

// API Order
const addOrderHandler = (request, h) => {
  const {
    id_order,
    date_transaction,
    time_transaction,
    order_quantity,
    total_price,
    id_payment,
    id_produk,
    id_user,
    id_shop
  } = request.payload

  const newOrder = {
    id_order,
    date_transaction,
    time_transaction,
    order_quantity,
    total_price,
    id_payment,
    id_produk,
    id_user,
    id_shop
  }

  order.push(newOrder)

  return h.response(newOrder).code(201)
}

const getOrderHandler = (request, h) => {
  return h.response(order).code(200)
}

// API Payment
const addPaymentHandler = (request, h) => {
  const { payment_method, payment_status, payment_info } = request.payload

  const newPayment = {
    id_payment: payment.length + 1,
    payment_method,
    payment_status,
    payment_info
  }

  payment.push(newPayment)

  return h.response(newPayment).code(201)
}

const getPaymentHandler = (request, h) => {
  return h.response(payment).code(200)
}

const updatePaymentHandler = (request, h) => {
  const { id } = request.params
  const { payment_method, payment_status, payment_info } = request.payload

  const indexToUpdate = payment.findIndex((pay) => pay.id_payment === parseInt(id))

  if (indexToUpdate !== -1) {
    payment[indexToUpdate].payment_method = payment_method
    payment[indexToUpdate].payment_status = payment_status
    payment[indexToUpdate].payment_info = payment_info

    return h.response(payment[indexToUpdate]).code(200)
  }

  return h.response().code(404)
}

const deletePaymentHandler = (request, h) => {
  const { id } = request.params

  const indexToRemove = payment.findIndex((pay) => pay.id_payment === parseInt(id))

  if (indexToRemove !== -1) {
    payment.splice(indexToRemove, 1)
    return h.response().code(204)
  }

  return h.response().code(404)
}

// API Invoice
const addInvoiceHandler = (request, h) => {
  const { id_order } = request.payload

  const newInvoice = {
    id_invoice: invoice.length + 1,
    id_order
  }

  invoice.push(newInvoice)

  return h.response(newInvoice).code(201)
}

const getInvoiceHandler = (request, h) => {
  return h.response(invoice).code(200)
}

const updateInvoiceHandler = (request, h) => {
  const { id } = request.params
  const { order_id } = request.payload

  const indexToUpdate = invoice.findIndex((inv) => inv.id_invoice === parseInt(id))

  if (indexToUpdate !== -1) {
    invoice[indexToUpdate].order_id = order_id
    return h.response(invoice[indexToUpdate]).code(200)
  }

  return h.response().code(404)
}

const deleteInvoiceHandler = (request, h) => {
  const { id } = request.params

  const indexToRemove = invoice.findIndex((invoice) => invoice.id_invoice === parseInt(id))

  if (indexToRemove !== -1) {
    invoice.splice(indexToRemove, 1)
    return h.response().code(204)
  }

  return h.response().code(404)
}

// API Rating
const getRatingHandler = (request, h) => {
  return h.response(rating).code(200)
}

const addRatingHandler = (request, h) => {
  const { id_rating, id_user, id_shop, ratingValue } = request.payload
  
  const newRating = {
    id_rating,
    id_user,
    id_shop,
    rating: ratingValue
  }

  rating.push(newRating)

  return h.response(newRating).code(201)
}

const updateRatingHandler = (request, h) => {
  const { id } = request.params
  const { id_user, id_shop, ratingValue } = request.payload

  const indexToUpdate = rating.findIndex((r) => r.id_rating === parseInt(id))

  if (indexToUpdate !== -1) {
    rating[indexToUpdate].id_user = id_user
    rating[indexToUpdate].id_shop = id_shop
    rating[indexToUpdate].rating = ratingValue

    return h.response(rating[indexToUpdate]).code(200)
  }

  return h.response().code(404)
}

const deleteRatingHandler = (request, h) => {
  const { id } = request.params

  const indexToRemove = rating.findIndex((r) => r.id_rating === parseInt(id))

  if (indexToRemove !== -1) {
    rating.splice(indexToRemove, 1)
    return h.response().code(204)
  }

  return h.response().code(404)
}

// API Recommendation
const getRecommendationHandler = (request, h) => {
  return h.response(recommendation).code(200)
}

const addRecommendationHandler = (request, h) => {
  const { id_user, id_product } = request.payload

  const newRecommendation = {
    id_recommendation: recommendation.length + 1,
    id_user,
    id_product
  }

  recommendation.push(newRecommendation)

  return h.response(newRecommendation).code(201)
}

const updateRecommendationHandler = (request, h) => {
  const { id } = request.params
  const { id_user, id_product } = request.payload

  const indexToUpdate = recommendation.findIndex((rec) => rec.id_recommendation === parseInt(id))

  if (indexToUpdate !== -1) {
    recommendation[indexToUpdate].id_user = id_user
    recommendation[indexToUpdate].id_product = id_product

    return h.response(recommendation[indexToUpdate]).code(200)
  }

  return h.response().code(404)
}

const deleteRecommendationHandler = (request, h) => {
  const { id } = request.params

  const indexToRemove = recommendation.findIndex((rec) => rec.id_recommendation === parseInt(id))

  if (indexToRemove !== -1) {
    recommendation.splice(indexToRemove, 1)
    return h.response().code(204)
  }

  return h.response().code(404)
}

module.exports = {
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
}
