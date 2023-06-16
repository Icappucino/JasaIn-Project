const Hapi = require('@hapi/hapi')
const routes = require('./routes')

const init = async () => {
  const server = Hapi.server({
    port: 5000,
    host: process.env.NODE_ENV !== 'production' ? 'localhost' : '0.0.0.0',
    routes: {
      cors: {
        origin: ['*']
      }
    }
  })

  // Register routes
  server.route(routes)

  try {
    await server.start()
    console.log('Server running on', server.info.uri)
  } catch (error) {
    console.error('Error starting server:', error)
    process.exit(1)
  }
}

init()
