from ariadne.asgi import GraphQL

from .schema import schema

app = GraphQL(schema, debug=True)

# ...or add GraphQL API to your favorite web framework
from ariadne.contrib.django.views import GraphQLView
from django.urls import include, path

from .schema import schema

urlpatterns = [
    ...
    path('graphql/', GraphQLView.as_view(schema=schema), name='graphql'),
]