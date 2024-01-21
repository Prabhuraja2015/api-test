package utils;

public enum ApiResources {
    Collection("/api/nl/collection");
    private String resource;
    ApiResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
